// #Sireum

package isolette.Monitor

import org.sireum._
import isolette.GumboXUtil.GumboXResult
import isolette.RandomLib
import org.sireum.Random.Gen64
import org.sireum.Random.Impl.Xoshiro256

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

// Distribute SlangCheck test runners

@record class Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_GumboX_DSC_TestRunner
  extends Random.Gen.TestRunner[Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_P]
  with Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_GumboX_TestHarness {

  val verbose: B = F

  val seedGen: Gen64 = Random.Gen64Impl(Xoshiro256.create)
  val ranLibcurrent_tempWstatus: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))
  val ranLiblower_alarm_temp: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))
  val ranLibmonitor_mode: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))
  val ranLibupper_alarm_temp: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))

  override def next(): Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_P = {
    val api_current_tempWstatus = ranLibcurrent_tempWstatus.nextIsolette_Data_ModelTempWstatus_impl()
    val api_lower_alarm_temp = ranLiblower_alarm_temp.nextIsolette_Data_ModelTemp_impl()
    val api_monitor_mode = ranLibmonitor_mode.nextIsolette_Data_ModelMonitor_ModeType()
    val api_upper_alarm_temp = ranLibupper_alarm_temp.nextIsolette_Data_ModelTemp_impl()
    return Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_P(
      api_current_tempWstatus, api_lower_alarm_temp, api_monitor_mode, api_upper_alarm_temp
    )
  }

  override def toCompactJson(o: Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_P): String = {
    return isolette.JSON.fromMonitorManage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_P(o, T)
  }

  override def fromJson(json: String): Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_P = {
    isolette.JSON.toMonitorManage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_P(json) match {
      case Either.Left(o) => return o
      case Either.Right(msg) => halt(msg.string)
    }
  }

  override def test(o: Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_P): B = {
    BeforeEntrypoint()
    val r: B = testComputeCBV(o) match {
      case GumboXResult.Pre_Condition_Unsat =>
        isolette.DSC_RecordUnsatPre.report(isolette.JSON.fromMonitorManage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_P(o, T))
        T
      case GumboXResult.Post_Condition_Fail => F
      case GumboXResult.Post_Condition_Pass => T
    }
    AfterEntrypoint()
    return r
  }
}

@record class Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_GumboX_DSC_TestRunnerwL
  extends Random.Gen.TestRunner[Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_PS]
  with Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_GumboX_TestHarness {

  val verbose: B = F

  val seedGen: Gen64 = Random.Gen64Impl(Xoshiro256.create)
  val ranLiblastCmd: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))
  val ranLibcurrent_tempWstatus: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))
  val ranLiblower_alarm_temp: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))
  val ranLibmonitor_mode: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))
  val ranLibupper_alarm_temp: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))

  override def next(): Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_PS = {
    val In_lastCmd = ranLiblastCmd.nextIsolette_Data_ModelOn_OffType()
    val api_current_tempWstatus = ranLibcurrent_tempWstatus.nextIsolette_Data_ModelTempWstatus_impl()
    val api_lower_alarm_temp = ranLiblower_alarm_temp.nextIsolette_Data_ModelTemp_impl()
    val api_monitor_mode = ranLibmonitor_mode.nextIsolette_Data_ModelMonitor_ModeType()
    val api_upper_alarm_temp = ranLibupper_alarm_temp.nextIsolette_Data_ModelTemp_impl()
    return Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_PS(
      In_lastCmd, api_current_tempWstatus, api_lower_alarm_temp, api_monitor_mode, api_upper_alarm_temp
    )
  }

  override def toCompactJson(o: Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_PS): String = {
    return isolette.JSON.fromMonitorManage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_PS(o, T)
  }

  override def fromJson(json: String): Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_PS = {
    isolette.JSON.toMonitorManage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_PS(json) match {
      case Either.Left(o) => return o
      case Either.Right(msg) => halt(msg.string)
    }
  }

  override def test(o: Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_PS): B = {
    BeforeEntrypoint()
    val r: B = testComputeCBwLV(o) match {
      case GumboXResult.Pre_Condition_Unsat =>
        isolette.DSC_RecordUnsatPre.report(isolette.JSON.fromMonitorManage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_PreState_Container_PS(o, T))
        T
      case GumboXResult.Post_Condition_Fail => F
      case GumboXResult.Post_Condition_Pass => T
    }
    AfterEntrypoint()
    return r
  }
}