public class Town {
    private char name;
    boolean visited;

    public Town(char name) {
        this.name = name;
        this.visited = false;
    }

    public char getName() {
        return this.name;
    }

    public boolean getVisited() {
        return this.visited;
    }


}
