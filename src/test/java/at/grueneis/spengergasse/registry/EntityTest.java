package at.grueneis.spengergasse.registry;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Daniel on 22/01/14.
 */
public class EntityTest {

	@Test
	public void createEntityFromEmptyObject() {
		EFAttributeTestClass empty = new EFAttributeTestClass(1);
		Entity entity = new Entity(empty);

		assertThat(empty, is(entity.getObject()));
	}

    @Test
    public void createEntityAndGetNotDirty() {
        EFAttributeTestClass empty = new EFAttributeTestClass(1);
        Entity entity = new Entity(empty);
        Assert.assertFalse(entity.isObjectDirty());
    }

    @Test
    public void createEntityAndGetDirty() {
        EFAttributeTestClass empty = new EFAttributeTestClass(1);
        Entity entity = new Entity(empty);
        empty.setString("HELLO THERE");
        Assert.assertTrue(entity.isObjectDirty());
    }
}
