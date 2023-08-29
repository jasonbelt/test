package isolette.Monitor

import org.sireum._
import isolette.Monitor._
import isolette.GumboXUtil
import isolette.GumboXUtil.GumboXResult
import isolette.RandomLib
import org.sireum.Random.Gen64
import org.sireum.Random.Impl.Xoshiro256

// Do not edit this file as it will be overwritten if HAMR codegen is rerun
class Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_GumboX_Tests extends Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_GumboX_TestHarness_ScalaTest {

  // set failOnUnsatPreconditions to T if the unit tests should fail when either
  // SlangCheck is never able to satisfy a datatype's filter or the generated
  // test vectors are never able to satisfy an entry point's assume pre-condition
  var failOnUnsatPreconditions: B = F

  var verbose: B = F

  val seedGen: Gen64 = Random.Gen64Impl(Xoshiro256.create)
  val ranLibcurrent_tempWstatus: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))
  val ranLiblower_alarm_tempWstatus: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))
  val ranLibmonitor_mode: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))
  val ranLibupper_alarm_tempWstatus: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))
  val ranLiblastCmd: RandomLib = RandomLib(Random.Gen64Impl(Xoshiro256.createSeed(seedGen.genU64())))

  def next(): Option[Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_PreState_Container_P] = {
    try {
      val api_current_tempWstatus = ranLibcurrent_tempWstatus.nextIsolette_Data_ModelTempWstatus_impl()
      val api_lower_alarm_tempWstatus = ranLiblower_alarm_tempWstatus.nextIsolette_Data_ModelTempWstatus_impl()
      val api_monitor_mode = ranLibmonitor_mode.nextIsolette_Data_ModelMonitor_ModeType()
      val api_upper_alarm_tempWstatus = ranLibupper_alarm_tempWstatus.nextIsolette_Data_ModelTempWstatus_impl()

      return Some(Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_PreState_Container_P(api_current_tempWstatus,api_lower_alarm_tempWstatus,api_monitor_mode,api_upper_alarm_tempWstatus))
    } catch {
      case e: AssertionError =>
       // SlangCheck was unable to satisfy a datatype's filter
       return None()
    }
  }

  def nextwL(): Option[Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_PreState_Container_PS] = {
    try {
      val In_lastCmd = ranLiblastCmd.nextIsolette_Data_ModelOn_OffType()
      val api_current_tempWstatus = ranLibcurrent_tempWstatus.nextIsolette_Data_ModelTempWstatus_impl()
      val api_lower_alarm_tempWstatus = ranLiblower_alarm_tempWstatus.nextIsolette_Data_ModelTempWstatus_impl()
      val api_monitor_mode = ranLibmonitor_mode.nextIsolette_Data_ModelMonitor_ModeType()
      val api_upper_alarm_tempWstatus = ranLibupper_alarm_tempWstatus.nextIsolette_Data_ModelTempWstatus_impl()

      return Some(Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_PreState_Container_PS(In_lastCmd,api_current_tempWstatus,api_lower_alarm_tempWstatus,api_monitor_mode,api_upper_alarm_tempWstatus))
    } catch {
      case e: AssertionError =>
       // SlangCheck was unable to satisfy a datatype's filter
       return None()
    }
  }

  {
    for (i <- 0 to GumboXUtil.numTests) {
      this.registerTest(s"testInitialiseCB_$i") {
        testInitialiseCB() match {
          case GumboXResult.Pre_Condition_Unsat =>
            halt("Infeasible as initialize entry points cannot contain assume clauses and cannot access incoming ports or state variables")
          case GumboXResult.Post_Condition_Fail =>
            fail ("Post condition did not hold")
          case GumboXResult.Post_Condition_Pass =>
            if (verbose) {
              println ("Success!")
            }
        }
      }
    }
  }

  {
    for (i <- 0 to GumboXUtil.numTests) {
      this.registerTest(s"testComputeCB_$i") {
        var retry: B = T

        var j: Z = 0
        while (j < GumboXUtil.numTestVectorGenRetries && retry) {
          next() match {
            case Some(o) =>

              if (verbose && j > 0) {
                println(s"Retry $j:")
              }

              val results = testComputeCBV(o)

              if (verbose) {
                val tq = "\"\"\""
                println(st"""Replay Unit Test:
                            |  test("Replay testComputeCB_$i") {
                            |    val json = st${tq}${isolette.JSON.fromMonitorManage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_PreState_Container_P(o, T)}${tq}.render
                            |    val testVector = isolette.JSON.toMonitorManage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_PreState_Container_P(json).left
                            |    assert (testComputeCBV(testVector) == isolette.GumboXUtil.GumboXResult.$results)
                            |  }""".render)
              }

              results match {
                case GumboXResult.Pre_Condition_Unsat =>
                case GumboXResult.Post_Condition_Fail =>
                  fail ("Post condition did not hold")
                  retry = F
                case GumboXResult.Post_Condition_Pass =>
                  if (verbose) {
                    println ("Success!")
                  }
                  retry = F
              }
            case _ =>
          }
          j = j + 1
        }

        if (retry) {
          if (failOnUnsatPreconditions) {
            fail ("Unable to satisfy precondition")
          } else if (verbose) {
            cprintln(T, "Unable to satisfy precondition")
          }
        }
      }
    }
  }

  {
    for (i <- 0 to GumboXUtil.numTests) {
      this.registerTest(s"testComputeCBwL_$i") {
        var retry: B = T

        var j: Z = 0
        while (j < GumboXUtil.numTestVectorGenRetries && retry) {
          nextwL() match {
            case Some(o) =>

              if (verbose && j > 0) {
                println(s"Retry $j:")
              }

              val results = testComputeCBwLV(o)

              if (verbose) {
                val tq = "\"\"\""
                println(st"""Replay Unit Test:
                            |  test("Replay testComputeCBwL_$i") {
                            |    val json = st${tq}${isolette.JSON.fromMonitorManage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_PreState_Container_PS(o, T)}${tq}.render
                            |    val testVector = isolette.JSON.toMonitorManage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_PreState_Container_PS(json).left
                            |    assert (testComputeCBwLV(testVector) == isolette.GumboXUtil.GumboXResult.$results)
                            |  }""".render)
              }

              results match {
                case GumboXResult.Pre_Condition_Unsat =>
                case GumboXResult.Post_Condition_Fail =>
                  fail ("Post condition did not hold")
                  retry = F
                case GumboXResult.Post_Condition_Pass =>
                  if (verbose) {
                    println ("Success!")
                  }
                  retry = F
              }
            case _ =>
          }
          j = j + 1
        }

        if (retry) {
          if (failOnUnsatPreconditions) {
            fail ("Unable to satisfy precondition")
          } else if (verbose) {
            cprintln(T, "Unable to satisfy precondition")
          }
        }
      }
    }
  }
}