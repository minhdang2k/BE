package Lab10b.Ex1;

public class Dictionary<K,V> {
    private Word<K,V>[] words;

    public Dictionary(Word<K, V>[] words) {
        this.words = words;
    }
    public V findword(K keysearch){
        for (Word<K,V> word: words){
            if (word.isKey(keysearch)){
                return word.getValue();
            }
        }
        return null;
    }
}
