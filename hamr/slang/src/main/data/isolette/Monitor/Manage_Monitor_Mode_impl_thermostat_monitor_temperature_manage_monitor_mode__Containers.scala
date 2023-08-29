// #Sireum

package isolette.Monitor

import org.sireum._
import isolette._

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

// containers for the pre and post state values of ports and state variables

@sig trait Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PreState_Container extends art.DataContent {
  def api_current_tempWstatus: Isolette_Data_Model.TempWstatus_impl
  def api_interface_failure: Isolette_Data_Model.Failure_Flag_impl
  def api_internal_failure: Isolette_Data_Model.Failure_Flag_impl
}

// container for incoming ports
@datatype class Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PreState_Container_P (
  val api_current_tempWstatus: Isolette_Data_Model.TempWstatus_impl,
  val api_interface_failure: Isolette_Data_Model.Failure_Flag_impl,
  val api_internal_failure: Isolette_Data_Model.Failure_Flag_impl) extends Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PreState_Container

// container for incoming ports and state variables
@datatype class Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PreState_Container_PS (
  val In_lastMonitorMode: Isolette_Data_Model.Monitor_Mode.Type,
  val api_current_tempWstatus: Isolette_Data_Model.TempWstatus_impl,
  val api_interface_failure: Isolette_Data_Model.Failure_Flag_impl,
  val api_internal_failure: Isolette_Data_Model.Failure_Flag_impl) extends Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PreState_Container

@sig trait Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PostState_Container extends art.DataContent {
  def api_monitor_mode: Isolette_Data_Model.Monitor_Mode.Type
}

// container for outgoing ports
@datatype class Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PostState_Container_P (
  val api_monitor_mode: Isolette_Data_Model.Monitor_Mode.Type) extends Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PostState_Container

// container for outgoing ports and state variables
@datatype class Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PostState_Container_PS (
  val lastMonitorMode: Isolette_Data_Model.Monitor_Mode.Type,
  val api_monitor_mode: Isolette_Data_Model.Monitor_Mode.Type) extends Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_PostState_Container
