package jpa.start.ch07.mappedsuperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
// 두 개 이상의 매핑정보를 오버라이딩 할 수 있다
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "SELLER_ID")),
        @AttributeOverride(name = "name", column = @Column(name = "SELLER_NAME"))
})
@Entity
public class SellerMapped extends BaseEntity {

    private String phoneNumber;
}
