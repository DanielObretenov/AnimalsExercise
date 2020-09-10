package animals;

public abstract class Animal implements ProduceSound{
    private String name;
    private int age;
    private String gender;


    public Animal(String name, int age, String gender){
        setName(name);
        setAge(age);
        setGender(gender);
    }

    @Override
    public String toString() {
         return String.format("%s%n%s %d %s%n%s"
                 ,this.getClass().getSimpleName()
                 ,this.getName()
                 ,this.age,
                  this.gender
                , this.produceSound());
    }

    public void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public void setGender(String gender) {
        if (!gender.equals("Female") && !gender.equals("Male") ){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public void setAge(int age) {
        if (age<0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age =age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
