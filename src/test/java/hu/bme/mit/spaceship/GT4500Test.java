package hu.bme.mit.spaceship;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class GT4500Test {

  private TorpedoStore mockStore;
  private GT4500 ship;

  @Before
  public void init(){
    mockStore = mock(TorpedoStore.class);
    this.ship = new GT4500(mockStore,mockStore);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockStore.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(mockStore, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockStore.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    verify(mockStore, times(2)).fire(1);
  }

}
