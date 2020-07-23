package model;

public class InfoRequestModelBuilder {
    private Object id;
    private Object firstName;
    private Object lastName;
    private Object country;
    private Object city;
    private Object temperature;

    public InfoRequestModelBuilder id(Object id) {
        this.id = id;
        return this;
    }

    public InfoRequestModelBuilder firstName(Object firstName) {
        this.firstName = firstName;
        return this;
    }

    public InfoRequestModelBuilder lastName(Object lastName) {
        this.lastName = lastName;
        return this;
    }

    public InfoRequestModelBuilder country(Object country) {
        this.country = country;
        return this;
    }

    public InfoRequestModelBuilder city(Object city) {
        this.city = city;
        return this;
    }

    public InfoRequestModelBuilder temperature(Object temperature) {
        this.temperature = temperature;
        return this;
    }

    public InfoRequestModel build() {
        return new InfoRequestModel(id, firstName, lastName, country, city, temperature);
    }
}
