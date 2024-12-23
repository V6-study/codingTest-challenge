import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static class person {
        int cnt;
        int id;
        boolean isPosted;
        int order;

        public person(int id, int cnt, boolean isPosted, int order) {
            this.id = id;
            this.cnt = cnt;
            this.isPosted = isPosted;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        person[] arr = new person[101];
        List<person> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            int id = Integer.parseInt(st.nextToken());
            // 1. 첫 등장
            if (arr[id] == null) {
                arr[id] = new person(id, 1, false, i);
            }

            // 2. 걸려있는 후보에 재투표
            if (arr[id].isPosted) {
                arr[id].cnt++;
            }

            // 3. 게시된 적이 없다면
            else {
                if (list.size() == n) {
                    list.sort((o1, o2) -> {
                        if (o1.cnt == o2.cnt) {
                            return o2.order - o1.order;
                        }
                        return o2.cnt - o1.cnt;

                    });
                    arr[list.get(n - 1).id] = null;
                    list.remove(n - 1);
                }
                arr[id].isPosted = true;
                arr[id].cnt = 1;
                list.add(arr[id]);
            }
        }
        list.sort((o1, o2) -> o1.id - o2.id);
        for (person p : list) {
            System.out.print(p.id + " ");
        }
    }
}
