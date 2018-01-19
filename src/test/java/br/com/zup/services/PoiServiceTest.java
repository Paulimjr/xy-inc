package br.com.zup.services;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.zup.entity.Poi;
import br.com.zup.services.PoiService;

/**
 * Testes de servico do {@link Poi}
 *  
 * @author paulo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PoiServiceTest {

	@Mock
	private PoiService poiService;
	
	@Before
	public void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	  Mockito.mock(PoiService.class);
	}
	
	/**
	 * Test for findAll
	 */
	@Test
	public void test4findAll() {
		Mockito.when(poiService.findAll()).thenReturn(getMockPois());
		List<Poi> customers = poiService.findAll();
		Assert.assertEquals(customers, getMockPois());
		
		verify(poiService).findAll();
	}
		
	/**
	 * Test for findById
	 */
	@Test
	public void test4findById() {
		Mockito.when(poiService.findById(1)).thenReturn(getMockPois().get(0));
		Poi poi = poiService.findById(1);
		Assert.assertEquals(poi, getMockPois().get(0));
		
		verify(poiService).findById(1);
	}
	
	/**
	 * Test for findById
	 */
	@Test
	public void test4findByName() {
		Mockito.when(poiService.findByName("Lanchonete")).thenReturn(getMockPois());
		List<Poi> pois = poiService.findByName("Lanchonete");
		Assert.assertEquals(pois, getMockPois());
		
		verify(poiService).findByName("Lanchonete");
	}
	
	/**
	 * Test for insert
	 */
	@Test
	public void test4insert() {
		doCallRealMethod().when(poiService).insert(getMockPois().get(0));
	}
	
	/**
	 * Get mock list of pois
	 * 
	 * @return
	 */
	private List<Poi> getMockPois() {
		Poi poi1 = new Poi(1, "Lanchonete 1", 27, 12);
		Poi poi2 = new Poi(2, "Posto", 31, 18);
		Poi poi3 = new Poi(3, "Supermercado", 23, 6);
		
		List<Poi> list = new ArrayList<>();
		list.add(poi1);
		list.add(poi2);
		list.add(poi3);
		
		return list;
	}
	
}
