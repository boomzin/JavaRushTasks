
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

    public class Step {

        static Map<String, Long> clickCount(List<LogEntry> logs){
            Map<String, Long> clickCount =
                    logs.stream()
                            .collect(Collectors.groupingBy(LogEntry::getUrl, Collectors.counting()));
            return clickCount;
        }

        public static void main(String[] args) throws IOException {
            List<LogEntry> logs = new Vector<>();
            logs.add(new LogEntry(new Date(), "Khrusha", "stepik.org"));
            logs.add(new LogEntry(new Date(), "Khrusha", "stepik.org"));
            logs.add(new LogEntry(new Date(), "Karkusha", "stepik.org"));
            logs.add(new LogEntry(new Date(), "Stepashka", "stepik.org"));
            logs.add(new LogEntry(new Date(), "Khrusha", "github.com"));
            logs.add(new LogEntry(new Date(), "Karkusha", "github.com"));
            logs.add(new LogEntry(new Date(), "Stepashka", "stackoverflow.com"));
            logs.add(new LogEntry(new Date(), "Stepashka", "stackoverflow.com"));
            logs.add(new LogEntry(new Date(), "Stepashka", "stackoverflow.com"));
            for(Map.Entry <String, Long> entry: clickCount(logs).entrySet()){
                System.out.println(entry.toString());
            }
            String[] words = {"level", "bbaa", "ac"};
            String w = words[0];
            System.out.println(w.equals(new StringBuilder(w).reverse().toString()));
            Map<Boolean, List<String>> palindromeOrNoMap =
                    Arrays.stream(words)
                            .collect(Collectors.partitioningBy(s -> s.equals(new StringBuilder(s).reverse().toString())));
            for (Map.Entry<Boolean, List<String>> booleanListEntry : palindromeOrNoMap.entrySet()) {
                System.out.println(booleanListEntry.toString());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] strings = br.readLine().split(" ");
            int q1X = Integer.parseInt(strings[0]);
            int q1Y = Integer.parseInt(strings[1]);
            int q2X = Integer.parseInt(strings[2]);
            int q2Y = Integer.parseInt(strings[3]);
            if (Math.abs(q1X - q2X) == Math.abs(q1Y - q2Y) || q1X == q2X || q1Y == q2Y) {
                System.out.println("YES");
            } else System.out.println("NO");

        }
    }
