class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        } else {
            this.firstName = "";
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        } else {
            this.lastName = "";
        }
    }

    public String getFullName() {
        if (this.firstName.isEmpty() && this.lastName.isEmpty()) {
            return new String("Unknown");
        } else if (this.lastName.isEmpty()) {
            return this.firstName;
        } else if (this.firstName.isEmpty()) {
            return this.lastName;
        } else {
            return this.firstName + " " + this.lastName;
        }

    }
}