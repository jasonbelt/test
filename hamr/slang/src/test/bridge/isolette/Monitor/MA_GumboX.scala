package isolette.Monitor

import isolette.Config_F32
import org.sireum._

class MA_GumboX extends Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_GumboX_Tests {

  override def verbose: B = T
  this.failOnUnsatPreconditions = T

  def cf32(low: F32, high: F32): Config_F32 = return Config_F32(Some(low), Some(high), 100, T, _=>T)


  // what codegen would gen by default
  //override def getProfiles_P: MSZ[MA_Profile_P] = return MSZ(getDefaultProfile_P)

  //override def getProfiles_PS: MSZ[MA_Profile_PS] = return MSZ(getDefaultProfile_PS)


  override def getProfiles_P: MSZ[MA_Profile_P] = {
    var bound_plus_minus_10f = getDefaultProfile_P(name = "Increase bounds by ±10f")

    // NOTE: had to change set_Config_F32 to return the modified RandomLib which I think the
    //        bleeding edge version of slang check does already
    bound_plus_minus_10f = bound_plus_minus_10f(
      api_lower_alarm_temp =
        bound_plus_minus_10f.api_lower_alarm_temp.set_Config_F32(cf32(86f, 111f)),
      api_upper_alarm_temp =
        bound_plus_minus_10f.api_upper_alarm_temp.set_Config_F32(cf32(87f, 112f))
    )

    var sameBounds = getDefaultProfile_P(name = "Same Bounds")

    sameBounds = sameBounds(
      api_lower_alarm_temp =
        sameBounds.api_lower_alarm_temp.set_Config_F32(cf32(96, 101f)),
      api_upper_alarm_temp =
        sameBounds.api_upper_alarm_temp.set_Config_F32(cf32(97f, 102f))
    )

    return MSZ(getDefaultProfile_P, bound_plus_minus_10f, sameBounds)
  }

  // example of rerunning.
  //   - Could have helper methods that fetch the profile via the name,
  //     or methods that convert the msz to a map where the keys are the profile name, or
  //     have getProfile_X return a map ...
  //
  //   - Would be nice to be able to just rerun the selected profiles rather than rerunning
  //     all + the selected ones
  this.profileTestComputeCB(getProfiles_P(1)(name = "Rerun ±10f profile"))


  // don't run any tests involving random state vars
  override def getProfiles_PS: MSZ[MA_Profile_PS] = {
    return MSZ()//MSZ(getDefaultProfile_PS)
  }

}
