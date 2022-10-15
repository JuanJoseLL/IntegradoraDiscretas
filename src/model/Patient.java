package model;

public class Patient {
    private String id;
    private String name;
    private String genre;
    private int pregnant;
    private int elderly;
    private int illness;
    private int priority;
    public Patient(String id, String name, int genre, int pregnant, int elderly, int illness) {
        this.id = id;
        this.name = name;
        switch (genre){
            case 1: this.genre="Masculine";
                break;
            case 2:this.genre="Feminine";
                break;
        }
        if(pregnant == 1 || elderly == 1 || illness == 1){
            priority=1;
        }else{
            priority=0;
        }
        this.pregnant = pregnant;
        this.elderly = elderly;
        this.illness = illness;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPregnant() {
        return pregnant;
    }

    public void setPregnant(int pregnant) {
        this.pregnant = pregnant;
    }

    public int getElderly() {
        return elderly;
    }

    public void setElderly(int elderly) {
        this.elderly = elderly;
    }

    public int getIllness() {
        return illness;
    }

    public void setIllness(int illness) {
        this.illness = illness;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name+"       "+((illness==1)?"  Yes  ":"  No  ")+"       "+priority;
    }
}
