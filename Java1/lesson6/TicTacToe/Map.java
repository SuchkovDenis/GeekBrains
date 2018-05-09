class Map {
	private char[][] map;   // Игровое поле
    private int size;      // Размер игрового поля
    private int dotsToWin; // Количество точек для победы
    private char dotEmpty = '•';

    Map(int size, int dotsToWin) {
        this.size = size;
        this.dotsToWin = dotsToWin;
        initMap();
    }

    private void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size ; i++)
            for (int j = 0; j < size ; j++)
                map[i][j] = dotEmpty;
    }

    public void changeMap(int x, int y, char dot) {
        map[y][x] = dot;
    }

    public int getSize() {
        return size;
    }

    public int getDotsToWin() {
        return dotsToWin;
    }

    public void show() {
        for (int i = 0; i <= size ; i++) 
            System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < size ; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j<size ; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

    public boolean checkWin(char symb) {
        int line1, line2, diagonal1, diagonal2;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - dotsToWin ; j++) {
                line1 = line2 = diagonal1 = diagonal2 = 0;
                
                for (int k = 0; k < dotsToWin ; k++) {
                    if (map[i][j+k]==symb)
                        line1 += 1;
                    if (map[j+k][i]==symb)
                        line2 += 1; 

                    if (i <= size - dotsToWin) {
                        if (map[i+k][j+k]==symb)
                            diagonal1 += 1;
                        if (map[i+k][j+dotsToWin-k-1] == symb)
                            diagonal2 += 1; 
                    }
                }
                if (line1==dotsToWin || line2==dotsToWin || diagonal1==dotsToWin || diagonal2==dotsToWin)
                    return true;
            }
        }
        return false;
    }

    public boolean isCellValid(int x, int y) {
        if ((x >= 0) && (x < size) && (y >= 0) && (y < size) && (map[y][x] == dotEmpty))
            return true;
        else
            return false;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == dotEmpty)
                    return false;
            }
        }
        return true;
    }
}