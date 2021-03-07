package com.soickm.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pocs")
public class POC {

    class Issue {
        private int id;
        private String url;

        @JsonProperty("id")
        public int getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(int id) {
            this.id = id;
        }

        @JsonProperty("url")
        public String getUrl() {
            return url;
        }

        @JsonProperty("url")
        public void setUrl(String url) {
            this.url = url;
        }
    }

    class Other {
        private int id;
        private String name;

        @JsonProperty("id")
        public int getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(int id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }
    }

    class Product {
        private String product;

        @JsonProperty("product")
        public String getProduct() {
            return product;
        }

        @JsonProperty("product")
        public void setProduct(String product) {
            this.product = product;
        }
    }

    class Person {

        private String type;
        private String first;
        private String last;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
        @JsonProperty("first")
        public String getFirst() {
            return first;
        }

        @JsonProperty("first")
        public void setFirst(String first) {
            this.first = first;
        }

        @JsonProperty("last")
        public String getLast() {
            return last;
        }

        @JsonProperty("last")
        public void setLast(String last) {
            this.last = last;
        }
    }

    private int index;
    private String guid;
    private String account;
    private String campaign;
    private boolean isActive;
    private String balance;
    private Product[] product;
    private String comments;
    private Person[] people;
    private Issue[] issues;
    private String[] tags;
    private String favoriteFruit;

    @JsonProperty("index")
    public int getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(int index) {
        this.index = index;
    }

    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    @JsonProperty("guid")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty("account")
    public String getAccount() {
        return account;
    }

    @JsonProperty("account")
    public void setAccount(String account) {
        this.account = account;
    }

    @JsonProperty("campaign")
    public String getCampaign() {
        return campaign;
    }

    @JsonProperty("campaign")
    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    @JsonProperty("isActive")
    public boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("balance")
    public String getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(String balance) {
        this.balance = balance;
    }

    @JsonProperty("product")
    public Product[] getProduct() {
        return product;
    }

    @JsonProperty("product")
    public void setProduct(Product[] product) {
        this.product = product;
    }

    @JsonProperty("comments")
    public String getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(String comments) {
        this.comments = comments;
    }

    @JsonProperty("people")
    public Person[] getPeople() {
        return people;
    }

    @JsonProperty("people")
    public void setPeople(Person[] people) {
        this.people = people;
    }

    @JsonProperty("issues")
    public Issue[] getIssues() {
        return issues;
    }

    @JsonProperty("issues")
    public void setIssues(Issue[] issues) {
        this.issues = issues;
    }

    @JsonProperty("tags")
    public String[] getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @JsonProperty("favoriteFruit")
    public String getFavoriteFruit() {
        return favoriteFruit;
    }

    @JsonProperty("favoriteFruit")
    public void setFavoriteFruit(String favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }
}

