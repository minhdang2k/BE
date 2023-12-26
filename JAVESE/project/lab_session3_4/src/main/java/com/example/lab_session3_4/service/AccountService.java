package com.example.lab_session3_4.service;

import com.example.lab_session3_4.dto.*;
import com.example.lab_session3_4.entity.*;
import com.example.lab_session3_4.exception.AccountException;
import com.example.lab_session3_4.mapper.Mapper;
import com.example.lab_session3_4.repository.AccountCourseRepository;
import com.example.lab_session3_4.repository.AccountRepository;
import com.example.lab_session3_4.repository.CourseRepository;
import com.example.lab_session3_4.repository.UserRepository;
import com.example.lab_session3_4.security.CustomUserDetails;
import com.example.lab_session3_4.security.JwtGenerated;
import com.example.lab_session3_4.security.JwtTokenUtil;
import com.example.lab_session3_4.util.AccountUtil;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final AccountCourseRepository accountCourseRepository;
    private final AccountCourseService accountCourseService;
    private final Mapper mapper;
    private final AccountUtil accountUtil;
    private final PasswordEncoder passwordEncoder;
    private final  AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public AccountService(AccountRepository accountRepository,
                          UserRepository userRepository,
                          CourseRepository courseRepository,
                          AccountCourseRepository accountCourseRepository,
                          AccountCourseService accountCourseService,
                          Mapper mapper,
                          AccountUtil accountUtil,
                          PasswordEncoder passwordEncoder,
                          AuthenticationManager authenticationManager,
                          JwtTokenUtil jwtTokenUtil) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.accountCourseRepository = accountCourseRepository;
        this.accountCourseService = accountCourseService;
        this.mapper = mapper;
        this.accountUtil = accountUtil;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public UserAccountResDTO create(UserAccountReqDTO newAcc) {
        String errMsg = accountUtil.validateRegisterData(newAcc);
        if (errMsg != null){
            throw new AccountException(errMsg);
        }

        Optional<Account> foundAcc = accountRepository.findByUsername(newAcc.getUsername());
        if (foundAcc.isPresent()) {
            throw new AccountException("Username is exists");
        }

        Optional<User> foundUser = userRepository.findByEmail(newAcc.getEmail());
        if (foundUser.isPresent()) {
            throw new AccountException("Email is exists");
        }
        User user = new User();
        user.setFirstName(newAcc.getFirstName());
        user.setLastName(newAcc.getLastName());
        user.setEmail(newAcc.getEmail());

        Account account = new Account();
        account.setUsername(newAcc.getUsername());
        account.setPassword(passwordEncoder.encode(newAcc.getPassword()));
        account.setStatus(true);
        account.setCreateDate(new Date());
        account.setUser(user);

//        Set<Role> roles = new HashSet<Role>();
//        roles.add("ADMIN");
//
//        account.setRoles(new HashSet<>().add("ADMIN"));

        return mapper.mapToUserAccountDTO(accountRepository.save(account));


    }
    public ResponseDTO<LoginResDTO> login(LoginReqDTO account){
        try{
            var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
            if (authentication.isAuthenticated()){
                CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
                JwtGenerated jwtGenerated = jwtTokenUtil.generateToken(userDetails);
                return ResponseDTO.<LoginResDTO>builder()
                        .status(HttpStatus.OK)
                        .message("Login success")
                        .data(
                                LoginResDTO.builder()
                                        .accessToken(jwtGenerated.getAccessToken())
                                        .expiredIn(jwtGenerated.getExpiredIn())
                                        .roles(userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                                        .build()
                        ).build();
            } else {
                throw new UsernameNotFoundException("Not found username: " + account.getUsername());
            }
        } catch (AuthenticationException e ){
            throw new AccountException(e.getMessage());
        }

    }

    public UserAccountResDTO findById(Long id) {
        Optional<Account> foundAcc = accountRepository.findById(id);
        if (foundAcc.isPresent()) {
            Account account = foundAcc.get();
            //            return ResponseDTO.<UserAccountResDTO>builder().status(HttpStatus.OK).message("Found account with id = " + id + ".").data(userAccountResDTO).build();
            return mapper.mapToUserAccountDTO(account);
        }
//        return ResponseDTO.<UserAccountResDTO>builder().status(HttpStatus.NOT_FOUND).message("Not found account with id = " + id + ".").build();
        throw new AccountException("Not found account with id = " + id + ".");
    }

    public List<UserAccountResDTO> findAll() {
        List<Account> list = accountRepository.findAll();
        if (list.isEmpty()) {
            throw new AccountException("Not found list accounts");
        }

        return mapper.mapToListUserAccountDTO(list);
    }
    public List<UserAccountResDTO> findAllWithPagingAndSorting(int offset, int pageSize, String field) {
        Page<Account> list = accountRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)));
        if (list.isEmpty()) {
            throw new AccountException("Not found list accounts");
        }

        List<Account> accountList= list.getContent();

        return mapper.mapToListUserAccountDTO(accountList);
    }

    public ResponseDTO<Void> deleteById(Long id) {
        Optional<Account> foundAcc = accountRepository.findById(id);
        if (foundAcc.isEmpty()) {
            return ResponseDTO.<Void>builder().status(HttpStatus.NOT_FOUND).message("Not found account to delete with id = " + id + ".").build();
        }

        boolean isExist = accountCourseRepository.existsAccountCourseByAccount_Id(id);
        if (isExist){
            //throw new AccountException("This account is currently attending courses.");
            return ResponseDTO.<Void>builder().status(HttpStatus.NOT_IMPLEMENTED).message("This account is currently attending courses.").build();
        }

        userRepository.deleteById(foundAcc.get().getUser().getId());
        accountRepository.deleteById(id);
        return ResponseDTO.<Void>builder().status(HttpStatus.OK).message("Deleted account with id = " + id + ".").build();
    }

    public ResponseDTO<UserAccountResDTO> updateById(UserAccountReqDTO accUpdate, Long id) {
        Optional<Account> foundAcc = accountRepository.findById(id);
        if (foundAcc.isEmpty()) {
            return ResponseDTO.<UserAccountResDTO>builder().status(HttpStatus.NOT_FOUND).message("Not found account to update with id = " + id + ".").build();
        }

        Account account = foundAcc.get();
        User user = account.getUser();

        if (!account.isStatus()) {
            return ResponseDTO.<UserAccountResDTO>builder().status(HttpStatus.NOT_IMPLEMENTED).message("Account with id = " + id + " is disable").build();
        }
        Optional<Account> foundAccByUsername = accountRepository.findByUsername(accUpdate.getUsername());
        if (foundAccByUsername.isPresent() && !accUpdate.getUsername().equals(foundAcc.get().getUsername())) {
            return ResponseDTO.<UserAccountResDTO>builder().status(HttpStatus.NOT_IMPLEMENTED).message("Username is exists").build();
        }
        Optional<User> foundUserByEmail = userRepository.findByEmail(accUpdate.getEmail());
        if (foundUserByEmail.isPresent() && !accUpdate.getEmail().equals(foundAcc.get().getUser().getEmail())) {
            return ResponseDTO.<UserAccountResDTO>builder().status(HttpStatus.NOT_IMPLEMENTED).message("Email is exists").build();
        }

        user.setFirstName(accUpdate.getFirstName());
        user.setLastName(accUpdate.getLastName());
        user.setEmail(accUpdate.getEmail());

        account.setUsername(accUpdate.getUsername());
        account.setPassword(passwordEncoder.encode(accUpdate.getPassword()));

        account.setUser(user);

        UserAccountResDTO userAccountResDTO = mapper.mapToUserAccountDTO(accountRepository.save(account));
        return ResponseDTO.<UserAccountResDTO>builder().status(HttpStatus.OK).message("Update account success with id = " + id + ".").data(userAccountResDTO).build();
    }


    public ResponseDTO<UserAccountResDTO> updateStatus(Long id, String type) {
        Optional<Account> foundAcc = accountRepository.findById(id);
        if (foundAcc.isPresent()) {
            Account account = foundAcc.get();
            switch (type) {
                case "enable" -> {
                    account.setStatus(true);
                }
                case "disable" -> {
                    account.setStatus(false);
                }
                default -> ResponseDTO.builder().status(HttpStatus.NOT_IMPLEMENTED).message("Invalid type").build();
            }
            UserAccountResDTO userAccountResDTO = mapper.mapToUserAccountDTO(accountRepository.save(account));
            return ResponseDTO.<UserAccountResDTO>builder().status(HttpStatus.OK).message(type.toUpperCase() + " account success with id = " + id + ".").data(userAccountResDTO).build();
        }
        return ResponseDTO.<UserAccountResDTO>builder().status(HttpStatus.NOT_FOUND).message("Not found account to update with id = " + id + ".").build();
    }

    public ResponseDTO<AccountCourseResDTO> assignCourse(Long account_id, Long course_id) {
        Optional<Account> foundAcc = accountRepository.findById(account_id);
        if (foundAcc.isEmpty()){
            return ResponseDTO.<AccountCourseResDTO>builder()
                    .status(HttpStatus.NOT_IMPLEMENTED)
                    .message("Not found account with id = " + account_id +".")
                    .build();
        }

        Optional<Course> foundCourse = courseRepository.findById(course_id);
        if (foundCourse.isEmpty()){
            return ResponseDTO.<AccountCourseResDTO>builder()
                    .status(HttpStatus.NOT_IMPLEMENTED)
                    .message("Not found course with id = " + course_id +".")
                    .build();
        }

        Account account = foundAcc.get();
        Course course = foundCourse.get();
        Date currDate = new Date();

        if (!account.isStatus()) {
            return ResponseDTO.<AccountCourseResDTO>builder().status(HttpStatus.NOT_IMPLEMENTED).message("Account with id = " + account_id + " is disable").build();
        }

        if (currDate.compareTo(course.getStartDate()) > 0){
            return ResponseDTO.<AccountCourseResDTO>builder()
                    .status(HttpStatus.NOT_IMPLEMENTED)
                    .message("Assign fail, the course is started.")
                    .build();
        }
        AccountCourse accountCourse = new AccountCourse();
        accountCourse.setAccount(account);
        accountCourse.setCourse(course);
        accountCourse.setRegisDate(currDate);
        accountCourse.setPurchase(course.getPrice());

        return accountCourseService.create(accountCourse);

    }
    public ResponseDTO<Void> unAssignCourse(Long account_id, Long course_id) {
        Optional<Account> foundAcc = accountRepository.findById(account_id);
        if (foundAcc.isEmpty()){
            return ResponseDTO.<Void>builder()
                    .status(HttpStatus.NOT_IMPLEMENTED)
                    .message("Not found account with id = " + account_id +".")
                    .build();
        }

        Optional<Course> foundCourse = courseRepository.findById(course_id);
        if (foundCourse.isEmpty()){
            return ResponseDTO.<Void>builder()
                    .status(HttpStatus.NOT_IMPLEMENTED)
                    .message("Not found course with id = " + course_id +".")
                    .build();
        }


        return accountCourseService.delete(account_id, course_id);

    }
}
