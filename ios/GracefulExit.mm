#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(GracefulExit, NSObject)

+ (BOOL)requiresMainQueueSetup
{
  return false;  // only do this if your module initialization relies on calling UIKit!
}

RCT_EXTERN_METHOD(exit: (RCTPromiseResolveBlock)resolver rejecter: (RCTPromiseRejectBlock)rejecter)

@end
