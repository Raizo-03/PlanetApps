    package com.example.planets;


    //Model Class - defines the attributes of items in the list
    public class Planet {
        //Attributes
        private String planetName;
        private String moonCount;

        private int planetImage; // reference id of the resource

        public Planet(String planetName, String moonCount, int planetImage) {
            this.planetName = planetName;
            this.moonCount = moonCount;
            this.planetImage = planetImage;
        }

        //Getters and Setters
        public String getPlanetName() {
            return planetName;
        }

        public int getPlanetImage() {
            return planetImage;
        }

        public String getMoonCount() {
            return moonCount;
        }

        public void setPlanetName(String planetName) {
            this.planetName = planetName;
        }

        public void setMoonCount(String moonCount) {
            this.moonCount = moonCount;
        }

        public void setPlanetImage(int planetImage) {
            this.planetImage = planetImage;
        }
    }
