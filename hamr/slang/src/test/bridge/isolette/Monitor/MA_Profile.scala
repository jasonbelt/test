// #Sireum

package isolette.Monitor

import isolette.RandomLib
import org.sireum._

@msig trait MA_Profile {
  def name: String
  def api_current_tempWstatus: RandomLib
  def api_lower_alarm_temp: RandomLib
  def api_monitor_mode: RandomLib
  def api_upper_alarm_temp: RandomLib
}

@record class MA_Profile_P(val name: String,
                           var api_current_tempWstatus: RandomLib,
                           var api_lower_alarm_temp: RandomLib,
                           var api_monitor_mode: RandomLib,
                           var api_upper_alarm_temp: RandomLib) extends MA_Profile

@record class MA_Profile_PS (val name: String,
                             var In_lastCmd: RandomLib,
                             var api_current_tempWstatus: RandomLib,
                             var api_lower_alarm_temp: RandomLib,
                             var api_monitor_mode: RandomLib,
                             var api_upper_alarm_temp: RandomLib) extends MA_Profile

