package jpa.start;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;

import java.util.Locale;

/**
 * 하이버네이트4 의 ImprovedNamingStrategy 클래스를 하이버네이트 5 에서 사용할 수 있도록
 * 누군가 다시 구현해놓은 것임. 동일성능 보장은 없음.
 */
public class NamingStrategyHibernate4Impl extends ImplicitNamingStrategyJpaCompliantImpl {

    @Override
    protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
        return super.toIdentifier(addUnderscores(stringForm), buildingContext);
    }

    protected static String addUnderscores(String name) {
        final StringBuilder buf = new StringBuilder(name.replace('.', '_'));
        for (int i = 1; i < buf.length() - 1; i++) {
            if (Character.isLowerCase(buf.charAt(i - 1))
                    && Character.isUpperCase(buf.charAt(i))
                    && Character.isLowerCase(buf.charAt(i + 1))) {
                buf.insert(i++, '_');
            }
        }
        return buf.toString().toLowerCase(Locale.ROOT);
    }
}