import java.util.*;

public class PhoneBook {
    private HashMap<String, List<Long>> phoneBook = new HashMap<>();


    public void add(String name, long phoneNum) {

        List<Long> phones = phoneBook.getOrDefault(name, new ArrayList<>());

        phones.add(phoneNum);

        phoneBook.put(name, phones);
    }


    public List<Long> find(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public LinkedHashMap<String, List<Long>> getPhoneBookSortedByPhoneCount() {

        List<Map.Entry<String, List<Long>>> entries = new ArrayList<>(phoneBook.entrySet());


        Collections.sort(entries, new Comparator<Map.Entry<String, List<Long>>>() {
            @Override
            public int compare(Map.Entry<String, List<Long>> entry1, Map.Entry<String, List<Long>> entry2) {
                return entry2.getValue().size() - entry1.getValue().size();
            }
        });
        LinkedHashMap<String, List<Long>> sortedPhoneBook = new LinkedHashMap<>();
        for (Map.Entry<String, List<Long>> entry : entries) {
            sortedPhoneBook.put(entry.getKey(), entry.getValue());
        }

        return sortedPhoneBook;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Алексей", 89207057634L);
        phoneBook.add("Алиса", 89227045634L);
        phoneBook.add("Богдан", 89001236539L);
        phoneBook.add("Василий", 89104569124L);
        phoneBook.add("Иван", 89305643281L);
        phoneBook.add("Степан", 89653457680L);


        System.out.println("Phone book:");
        for (Map.Entry<String, List<Long>> entry : phoneBook.getPhoneBookSortedByPhoneCount().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("\nFind Алиса:");
        List<Long> alicePhones = phoneBook.find("Алиса");
        System.out.println(alicePhones);

        System.out.println("\nFind Иван:");
        List<Long> ivanPhones = phoneBook.find("Иван");
        System.out.println(ivanPhones);
    }
}
