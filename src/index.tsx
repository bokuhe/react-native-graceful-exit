import { NativeModules, Platform } from 'react-native';
 
const LINKING_ERROR =
  `The package '@sleiv/react-native-graceful-exit' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';
 
function createModuleProxy<T>(moduleName: string): T {
  if (NativeModules[moduleName]) {
    return NativeModules[moduleName];
  } else {
    return new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    ) as T;
  }
}
 
export interface GracefulExitType {
  exit: () => Promise<void>;
}
 
export const GracefulExit = createModuleProxy<GracefulExitType>(
  'GracefulExit'
);