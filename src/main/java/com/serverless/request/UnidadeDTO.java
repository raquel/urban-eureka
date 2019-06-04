package com.serverless.request;

public class UnidadeDTO {

    private Long id;

    private String name;

    private String type;

    private String city;

    private String address;

    private String latitude;

    private String longitude;

    private String url;

    private String avatar;

    private Long sescId;

    private boolean active;

    public UnidadeDTO(Long id, String name, String type, String city, String address, String latitude, String longitude,
                      String url, String avatar, Long sescId, boolean active) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.city = city;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.url = url;
        this.avatar = avatar;
        this.sescId = sescId;
        this.active = active;
    }

    public UnidadeDTO() {
    }

    public static UnidadeDTOBuilder builder() {
        return new UnidadeDTOBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getCity() {
        return this.city;
    }

    public String getAddress() {
        return this.address;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getUrl() {
        return this.url;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public Long getSescId() {
        return this.sescId;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setSescId(Long sescId) {
        this.sescId = sescId;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String toString() {
        return "UnidadeDTO(id=" + this.getId() + ", name=" + this.getName() + ", type=" + this.getType() + ", city=" + this.getCity() +
                ", address=" + this.getAddress() + ", latitude=" + this.getLatitude() + ", longitude=" + this.getLongitude() +
                ", url=" + this.getUrl() + ", avatar=" + this.getAvatar() + ", sescId=" + this.getSescId() + ", active=" + this.isActive() + ")";
    }


    public static class UnidadeDTOBuilder {
        private Long id;
        private String name;
        private String type;
        private String city;
        private String address;
        private String latitude;
        private String longitude;
        private String url;
        private String avatar;
        private Long sescId;
        private boolean active;

        UnidadeDTOBuilder() {
        }

        public UnidadeDTO.UnidadeDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UnidadeDTO.UnidadeDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UnidadeDTO.UnidadeDTOBuilder type(String type) {
            this.type = type;
            return this;
        }

        public UnidadeDTO.UnidadeDTOBuilder city(String city) {
            this.city = city;
            return this;
        }

        public UnidadeDTO.UnidadeDTOBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UnidadeDTO.UnidadeDTOBuilder latitude(String latitude) {
            this.latitude = latitude;
            return this;
        }

        public UnidadeDTO.UnidadeDTOBuilder longitude(String longitude) {
            this.longitude = longitude;
            return this;
        }

        public UnidadeDTO.UnidadeDTOBuilder url(String url) {
            this.url = url;
            return this;
        }

        public UnidadeDTO.UnidadeDTOBuilder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public UnidadeDTO.UnidadeDTOBuilder sescId(Long sescId) {
            this.sescId = sescId;
            return this;
        }

        public UnidadeDTO.UnidadeDTOBuilder active(boolean active) {
            this.active = active;
            return this;
        }

        public UnidadeDTO build() {
            return new UnidadeDTO(id, name, type, city, address, latitude, longitude, url, avatar, sescId, active);
        }

        public String toString() {
            return "UnidadeDTO.UnidadeDTOBuilder(id=" + this.id + ", name=" + this.name + ", type=" + this.type +
                    ", city=" + this.city + ", address=" + this.address + ", latitude=" + this.latitude + ", longitude=" + this.longitude +
                    ", url=" + this.url + ", avatar=" + this.avatar + ", sescId=" + this.sescId + ", active=" + this.active + ")";
        }
    }
}
