/**
 * Copyright (C) 2015 An Honest Effort LLC, coping.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.anhonesteffort.uhd.types;

import org.junit.Test;

public class TimeSpecTest {

  @Test
  public void testConstructors() {
    TimeSpec TIME = new TimeSpec(40);
    assert Math.abs(TIME.get_real_secs() - 40.0) < 0.00001;

    TIME = new TimeSpec(20, 0.30);
    assert TIME.get_full_secs() == 20;
    assert Math.abs(TIME.get_frac_secs() - 0.30) < 0.00001;
  }

  @Test
  public void testGetSystemTime() {
    final TimeSpec TIME = TimeSpec.get_system_time();

    assert TIME.get_real_secs() >  0;
    assert TIME.get_full_secs() >  0;
    assert TIME.get_frac_secs() >= 0;
  }

  @Test
  public void testFromTicks() {
    final TimeSpec TIME = TimeSpec.from_ticks(100, 1.0);

    assert Math.abs(TIME.get_real_secs() - 100.0) < 0.00001;
    assert TIME.get_full_secs() == 100;
    assert Math.abs(TIME.get_frac_secs()) < 0.00001;
  }

}
