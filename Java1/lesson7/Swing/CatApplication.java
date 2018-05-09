/**
* GeekBrains Java1 Homework 7 (Swing)
* @author Suchkov Denis
* @version dated Feb 19, 2018
* @link https://github.com/suchkovdenis
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CatApplication {
    private Cat[] cat = {new Cat("Мурка",4), new Cat("Барсик", 6), new Cat("Снежок", 8), new Cat("Толстыш", 38)};
    private Plate plate = new Plate(0);
    // окно программы
    private JFrame frame;

    // боковая панель (с кнопками для вызова кошек и информацией о них)
    private JPanel sideBar;

    // нижняя панель меню (с кнопкой "добавить еду в тарелку, текстовым полем и пр")
    private JPanel footer;

    // кнопки информации о кошках
    private JButton[] catButton = new JButton[cat.length];
    private JLabel[] catAppetiteLabel = new JLabel[cat.length];
    private JLabel[] catSatietyLabel  = new JLabel[cat.length]; 

    // кнопка для добавления еды в тарелку
    private JButton plateButton;
    private JLabel plateFood;
    private JTextField plateFoodText;
    private int i = 1;

    // Настройки экрана для комфортного отображения окна программы
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int sizeWidth = 600;
    private static final int sizeHeight = 400;
    private static final int locationX = (screenSize.width - sizeWidth) / 2;
    private static final int locationY = (screenSize.height - sizeHeight) / 2;

    public static void main(String[] args) {
        CatApplication app = new CatApplication();
    }

    public CatApplication() {
        frame = new JFrame();
        frame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        //frame.setResizable(false);
        
        // заполняем боковую панель кнопками и информацией о кошках
        sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
        for (int j = 0; j < cat.length ; j++) {
            catButton[j] = new JButton(cat[j].getName());
            catButton[j].addActionListener(new catListener(j));
            sideBar.add(catButton[j]);

            catAppetiteLabel[j] = new JLabel("Аппетит: " + cat[j].getAppetite());
            sideBar.add(catAppetiteLabel[j]);

            catSatietyLabel[j] = new JLabel("кошка голодна? " + !cat[j].isSatiety());
            sideBar.add(catSatietyLabel[j]);
        }

        // заполняем нижнюю панель
        footer = new JPanel();
        plateButton = new JButton("Добавить еды");
        plateButton.addActionListener(new plateListener());
        plateFood = new JLabel ("Еды на тарелке:" + plate.getFood());
        plateFoodText = new JTextField(5);
        footer.add(plateFood);
        footer.add(plateFoodText);
        footer.add(plateButton);

        DrawPanel drawPanel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.EAST,sideBar);
        frame.getContentPane().add(BorderLayout.SOUTH,footer);
        frame.getContentPane().add(drawPanel);
        frame.setVisible(true);
    }

    class plateListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int f;
            try {
                f = Integer.parseInt(plateFoodText.getText());
            } catch (Exception e) {
                f = 0;
            }
            plateFoodText.setText("");
            plate.putFood(f);
            plateFood.setText("Еды на тарелке:" + plate.getFood());
        }
    }

    class catListener implements ActionListener {
        int num;
        catListener(int num) {
            this.num = num;
        }
        public void actionPerformed(ActionEvent event) {
            cat[num].eat(plate);
            plateFood.setText("Еды на тарелке:" + plate.getFood());
            for (int j = 0; j < cat.length ; j++) {
                catSatietyLabel[j].setText("кошка голодна? " + !cat[j].isSatiety());
            }
        }
    }

    // Просто визуальное дополнение, не смотрите сюда, пожалуйста!)
    // P.s. - я просто понятия не имею о том, как правильно все это делать
    class DrawPanel extends JPanel {
        /* Хотел сделать так, чтобы кошка на экране ходила к тарелке и кушала.
         * Если она голодна - то показываются ее мысли о еде. 
         * Тарелка с едой тоже должна отображаться по-разному. Если пустая - то просто чашка
         * Если есть хоть какое-то количество еды - то с едой.
         * А пока можно поиграться только изменяя размер экрана - кошка будет ходить по экрану
        */
        public void paintComponent(Graphics g) {
            //заполняем  белым фон
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            if (i>200)
                i=0;
            //рисуем кота
            Image image = new ImageIcon("img/cat"+(i%10+1)+"_right.jpeg").getImage();
            g.drawImage(image,this.getWidth()-i*4,100,this);
            i++;
            //рисуем мысли кота
            Image imageThings = new ImageIcon("img/things.png").getImage();
            g.drawImage(imageThings,this.getWidth()+100-i*4,50,this);
            i++;

            //рисуем миску
            Image imagePlate = new ImageIcon("img/plate.png").getImage();
            g.drawImage(imagePlate,4,180,this);

            //рисуем еду
            Image imageFood = new ImageIcon("img/food.png").getImage();
            g.drawImage(imageFood,15,160,this);
        }
}
}



class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate plate) {
        if (!satiety) {
            int foodBefore = plate.getFood();
            plate.reduceFood(appetite);
            if (plate.getFood()<foodBefore)
                satiety = true;
        }
    }
    public boolean isSatiety() {
        return satiety;
    }
    public String getName() {
        return name;
    } 
    public int getAppetite() {
        return appetite;
    }
}

class Plate {
    private int food;
    public Plate(int food) {
        if (food>=0)
            this.food = food;
        else
            this.food = 0;
    }
    public void reduceFood(int food) {
        if (food<=this.food) 
            this.food -= food;
    }
    public void putFood(int food) {
        if (food>=0)
            this.food += food;
    }
    public int getFood() {
        return food;
    }
}

