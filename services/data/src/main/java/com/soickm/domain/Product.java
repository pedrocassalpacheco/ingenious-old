package com.soickm.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("products")
public class Product {

    public class Feature {

        public Feature(String feature) {
            this.feature = feature;
        }

        public String getFeature() {
            return feature;
        }

        public void setFeature(String feature) {
            this.feature = feature;
        }

        private String feature;
    }
    @Id
    private String _id;
    private String guid;
    private String product;
    private ArrayList<Feature> features;

    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public String getGuid() {
        return guid;
    }
    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public List<Feature> getFeatures() { return features;};
    public void setFeatures(List<Feature> features ) {
        this.features= (ArrayList<Feature>) features;
    };

    public void addFeature(String feature) {
        if (this.features == null) {
            this.features = new ArrayList<Feature>();
        }
        this.features.add(new Feature(feature));

    }
}

