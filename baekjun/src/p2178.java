import java.io.FileInputStream;
import java.util.*;
 
public class p2178 {
 
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int N;
    static int M;
 
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
 
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j)-'0';
                visited[i][j] = false;
            }
        }
        visited[0][0] = true;
        BFS(0, 0);
        System.out.println(arr[N - 1][M - 1]);
    }
 
    static public void BFS(int x, int y) {
 
        Queue<Dot> q = new LinkedList<Dot>();
        q.add(new Dot(x, y));
        //ť�� ������ ����
        while (!q.isEmpty()) {
            Dot d = q.poll();
            for (int i = 0; i < 4; i++) {
                //���� �湮�� ��ǥ nextX, nextY
                int nextX = d.x + dx[i];
                int nextY = d.y + dy[i];
                
                //���� ��ǥ�� ������ �Ѿ�� �ǳʶٱ�
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                //�̹� �湮�ߴ� ���̸� �ǳʶٱ�
                if (visited[nextX][nextY] || arr[nextX][nextY] == 0) {
                    continue;
                }
                //������ �湮�� ��ǥ�� ť�� �ִ´�.
                q.add(new Dot(nextX, nextY));
                //�迭�ȿ� ���� �湮�� ���� ���� �湮�ߴ� ������ 1ĭ �� �����ϹǷ� +1
                arr[nextX][nextY] = arr[d.x][d.y] + 1;
                //���� ��ǥ�� �湮�������� ǥ��
                visited[nextX][nextY] = true;
            }
        }
    }
}
 
class Dot {
    int x;
    int y;
 
    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}