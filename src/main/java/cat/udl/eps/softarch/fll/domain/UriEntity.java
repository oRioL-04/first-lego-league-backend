package cat.udl.eps.softarch.fll.domain;

import java.io.Serializable;
import org.atteo.evo.inflector.English;
import org.springframework.data.domain.Persistable;
import org.springframework.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uri")
public abstract class UriEntity<ID extends Serializable> implements Persistable<ID> {

	/**
	 * The uri string value.
	 */
	@SuppressWarnings("unused")
	private String uri;

	/**
	 * The value of the entity version.
	 */
	@Version
	private Long version;

	/**
	 * Method that builds the uri and returns it in string format.
	 * 
	 * @return Uri with uncapitalize letters in plural with name and id of the entity
	 */

	public String getUri() {
		String simpleClassName = this.getClass().getSimpleName();
		if (simpleClassName == null) {
			throw new IllegalStateException("Class name cannot be null");
		}
		return "/" + English.plural(StringUtils.uncapitalize(simpleClassName)) + "/" + getId();
	}


	/**
	 * Method that checks if the version is null or not and returns it in boolean format.
	 * 
	 * @return a boolean value if the version of the entity is null or not.
	 */
	@Override
	@JsonIgnore
	public boolean isNew() {
		return version == null;
	}
}
