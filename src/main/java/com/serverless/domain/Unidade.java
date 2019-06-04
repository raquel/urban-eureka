package com.serverless.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "unidade", uniqueConstraints = @UniqueConstraint(name = "uk_unidade_nome_tipo", columnNames = {"nome", "tipo"}))
public class Unidade implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", length = 10)
    private Long id;

    @Column(name = "nome", length = 64, nullable = false)
    private String name;

    @Column(name = "tipo", length = 19, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoUnidade type;

    @Column(name = "municipio", length = 64)
    private String city;

    @Column(name = "endereco", length = 512)
    private String address;

    @Column(name = "coord_lat", length = 8)
    private String latitude;

    @Column(name = "coord_lon", length = 9)
    private String longitude;

    @Column(name = "url", length = 128)
    private String url;

    @Column(name = "id_sesc", length = 10)
    private Long sescId;

    @Column(name = "status", length = 1, nullable = false)
    private boolean active;

    @Column(name = "avatar_ID")
    private String avatar;

    public Unidade(Long id, String name, TipoUnidade type, String city, String address, String latitude, String longitude, String url, Long sescId, boolean active, String avatar) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.city = city;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.url = url;
        this.sescId = sescId;
        this.active = active;
        this.avatar = avatar;
    }

    public Unidade() {
    }

    public static SescUnitBuilder builder() {
        return new SescUnitBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public TipoUnidade getType() {
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

    public Long getSescId() {
        return this.sescId;
    }

    public boolean isActive() {
        return this.active;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(TipoUnidade type) {
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

    public void setSescId(Long sescId) {
        this.sescId = sescId;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String toString() {
        return "SescUnit(id=" + this.getId() + ", name=" + this.getName() + ", type=" + this.getType() + ", city=" + this.getCity() +
                ", address=" + this.getAddress() + ", latitude=" + this.getLatitude() + ", longitude=" + this.getLongitude() +
                ", url=" + this.getUrl() + ", sescId=" + this.getSescId() + ", active=" + this.isActive() +
                ", avatar=" + this.getAvatar() + ")";
    }

    public static class SescUnitBuilder {
        private Long id;
        private String name;
        private TipoUnidade type;
        private String city;
        private String address;
        private String latitude;
        private String longitude;
        private String url;
        private Long sescId;
        private boolean active;
        private String avatar;

        SescUnitBuilder() {
        }

        public Unidade.SescUnitBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Unidade.SescUnitBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Unidade.SescUnitBuilder type(TipoUnidade type) {
            this.type = type;
            return this;
        }

        public Unidade.SescUnitBuilder city(String city) {
            this.city = city;
            return this;
        }

        public Unidade.SescUnitBuilder address(String address) {
            this.address = address;
            return this;
        }

        public Unidade.SescUnitBuilder latitude(String latitude) {
            this.latitude = latitude;
            return this;
        }

        public Unidade.SescUnitBuilder longitude(String longitude) {
            this.longitude = longitude;
            return this;
        }

        public Unidade.SescUnitBuilder url(String url) {
            this.url = url;
            return this;
        }

        public Unidade.SescUnitBuilder sescId(Long sescId) {
            this.sescId = sescId;
            return this;
        }

        public Unidade.SescUnitBuilder active(boolean active) {
            this.active = active;
            return this;
        }

        public Unidade.SescUnitBuilder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }


        public Unidade build() {
            return new Unidade(id, name, type, city, address, latitude, longitude, url, sescId, active, avatar);
        }

        public String toString() {
            return "SescUnit.SescUnitBuilder(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", " +
                    "city=" + this.city + ", address=" + this.address + ", latitude=" + this.latitude + ", " +
                    "longitude=" + this.longitude + ", url=" + this.url + ", sescId=" + this.sescId + ", active=" +
                    this.active + ", avatar=" + this.avatar + ")";
        }
    }
}
