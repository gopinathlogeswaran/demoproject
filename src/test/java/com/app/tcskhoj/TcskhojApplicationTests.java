package com.app.tcskhoj;

import com.app.tcskhoj.entity.Location;
import com.app.tcskhoj.repository.LocationRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TcskhojApplicationTests {


	@Mock
	LocationRepository locationRepository;

	@Test
	public void testFindByLocation() {
		Location location = new Location();
		location.setId(3);
		location.setCity("chennai");
		Mockito.when(locationRepository.findByName(Mockito.anyString())).thenReturn(location);
		Assert.assertNotNull(location);
		Assert.assertEquals(3, location.getId().intValue());


	}

	@Test
	public void testFindByCity() {
		Location location = new Location();
		location.setId(2);
		location.setCity("Bangalore");
		Mockito.when(locationRepository.findByName(Mockito.anyString())).thenReturn(location);
		Assert.assertNotNull(location);
		Assert.assertEquals(2, location.getId().intValue());


	}
}
