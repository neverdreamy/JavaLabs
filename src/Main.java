public class Main {
    public static void main(String[] args) throws Exception {
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[20];
        // Анализ аргументов командной строки и создание для них
        // экземпляров соответствующих классов для завтрака
        int itemsSoFar = 0;
        for (String arg: args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("IceCream")) {
// У мороженого – 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new IceCream(parts[1]);
            }
            if (parts[0].equals("Cheese")) {
// У сыра дополнительных параметров нет
                breakfast[itemsSoFar] = new Cheese();
            } else
            if (parts[0].equals("Apple")) {
// У яблока – 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new Apple(parts[1]);
            }
// ... Продолжается анализ других продуктов для завтрака
            itemsSoFar++;
        }
// Перебор всех элементов массива
        for (Food item: breakfast)
            if (item!=null)
// Если элемент не null – употребить продукт
                item.consume();
            else
// Если дошли до элемента null – значит достигли конца
// списка продуктов, ведь 20 элементов в массиве было
// выделено с запасом, и они могут быть не
// использованы все
                break;
        System.out.println("Всего хорошего!");
    }
}

interface Consumable {
    public abstract void consume();
}

abstract class Food implements Consumable {
    String name = null;

    public Food(String name) {
        this.name = name;
    }

    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Food)) return false; // Шаг 1
        if (name == null || ((Food) arg0).name == null) return false; // Шаг 2
        return name.equals(((Food) arg0).name); // Шаг 3
    }

    public String toString() {
        return name;
    }
}

class IceCream extends Food {
        // Новое внутреннее поле данных СИРОП
        private String sirup;
        public IceCream(String sirup) {
// Вызвать конструктор предка, передав ему имя класса
            super("Мороженое");
// Инициализировать сироп
            this.sirup = sirup;
        }
        // Переопределить способ употребления мороженого
        public void consume() {
            System.out.println(this + " съедено");
        }
        // Переопределѐнная версия метода toString(), возвращающая не только
// название продукта (мороженое), но и его сироп
        public String toString() {
            return super.toString() + " с сиропом '" + sirup.toUpperCase() + "'";
        }
    }

class Apple extends Food {
    // Новое внутреннее поле данных РАЗМЕР
    private String size;
    public Apple(String size) {
// Вызвать конструктор предка, передав ему имя класса
        super("Яблоко");
// Инициализировать размер яблока
        this.size = size;
    }
    // Переопределить способ употребления яблока
    public void consume() {
        System.out.println(this + " съедено");
    }
    // Селектор для доступа к полю данных РАЗМЕР
    public String getSize() {
        return size;
    }
    // Модификатор для изменения поля данных РАЗМЕР
    public void setSize(String size) {
        this.size = size;
    }
    // Переопределѐнная версия метода equals(), которая при сравнении
// учитывает не только поле name (Шаг 1), но и проверяет совместимость
// типов (Шаг 2) и совпадение размеров (Шаг 3)
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Apple)) return false; // Шаг 2
            return size.equals(((Apple)arg0).size); // Шаг 3
        } else
            return false;
    }
    // Переопределѐнная версия метода toString(), возвращающая не только
// название продукта, но и его размер
    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
}

class Cheese extends Food {
    public Cheese() {
        super("Сыр");
    }
    public void consume() {
        System.out.println(this + " съеден");
    }
// Переопределять метод equals() в данном классе не нужно, т.к. он
// не добавляет новых полей данных, а сравнение по внутреннему полю name
// уже реализовано в базовом классе
// Переопределять метод toString() в данном классе не нужно, т.к. он
// не добавляет внутренних полей данных, а возврат поля name уже
// реализован в версии toString() базового класса
}