package pers.ej.chapter07.item41;

/**
 * 测试覆盖方法
 * 执行哪个覆盖方法是根据对象运行时类型来判断的
 * Created by lgc on 17-6-10.
 */
class Wine {
    String name() {
        return "Wine";
    }
}

class SparklingWine extends Wine {
    @Override
    String name() {
        return "SparklingWine";
    }
}

class Champagne extends SparklingWine {
    @Override
    String name() {
        return "Champagne";
    }
}

public class Overriding {
    public static void main(String[] args) {
        Wine[] wines = {new Wine(), new SparklingWine(), new Champagne()};

        for (Wine wine : wines) {
            System.out.println(wine.name());
        }
    }
}
