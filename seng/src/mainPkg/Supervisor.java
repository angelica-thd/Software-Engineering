package mainPkg;

public class Supervisor{
    private final int id;
    private final String fullname;
    private final String email;

    public Supervisor(Builder builder){
        this.id = builder.id;
        this.fullname = builder.fullname;
        this.email = builder.email;
    }

    public static class Builder{
        private final int id;
        private final String fullname;
        private final String email;

        public Builder(int id, String fullname, String email){
            this.id = id;
            this.fullname = fullname;
            this.email = email;
        }

    }
}