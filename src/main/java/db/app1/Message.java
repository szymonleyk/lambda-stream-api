package db.app1;

public class Message {
    private String title;
    private String description;
    private String email;

    public Message(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Message(String title, String description, String email) {
        this.title = title;
        this.description = description;
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "------------------\nTitle: "+title+"\nMessage: "+ description +"\n----------------";
    }
}
