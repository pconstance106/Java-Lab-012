class Planet {
    private String name;
    private double mass;
    private double x;
    private double vx;
    public Planet(String name, double mass, double x, double ypos, double velocity) {
        this.name = name;
        this.mass = mass;
        this.x = x;
        this.vx = velocity;
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }
}