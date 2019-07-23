package com.uoft.food;

public class FoodProviderListItem implements ListItem {

    private String name;
    private String campus;
    private String building;
    private boolean open;

    public FoodProviderListItem() {
    }

    public String getName() {
        return name;
    }

    public String getCampus() {
        return campus;
    }

    public String getBuilding() {
        return building;
    }

    public boolean isOpen() {
        return open;
    }

    public static class Builder {
        private String name;
        private String campus;
        private String building;
        private boolean open;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCampus(String campus) {
            this.campus = campus;
            return this;
        }

        public Builder setBuilding(String building) {
            this.building = building;
            return this;
        }

        public Builder setOpen(boolean open) {
            this.open = open;
            return this;
        }

        public FoodProviderListItem build() {
            FoodProviderListItem listItem = new FoodProviderListItem();
            listItem.name = this.name;
            listItem.building = this.building;
            listItem.campus = this.campus;
            listItem.open = this.open;
            return listItem;

        }
    }
}
