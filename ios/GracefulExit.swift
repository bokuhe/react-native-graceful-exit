import Foundation
import UIKit
import React

@objc(GracefulExit)
class GracefulExit: NSObject, RCTBridgeModule {
  static func moduleName() -> String {
    return "GracefulExit"
  }
  
  @objc func exit(_ resolver: RCTPromiseResolveBlock,
                     rejecter: RCTPromiseRejectBlock) {
    DispatchQueue.main.async {
      UIApplication.shared.perform(#selector(NSXPCConnection.suspend))
      DispatchQueue.main.asyncAfter(deadline: .now() + 1.0) {
          Darwin.exit(0)
      }
    }
    resolver(nil)
  }
}
