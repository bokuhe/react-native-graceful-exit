# react-native-graceful-exit

Gracefully exit your React Native app by transitioning it to the home screen before termination.

## Installation

```sh
npm install @sleiv/react-native-graceful-exit

or

yarn add @sleiv/react-native-graceful-exit
```

## Usage

```ts
import { GracefulExit } from '@sleiv/react-native-graceful-exit';

// ...
GracefulExit.exit().catch((e) => {
  console.error(e);
});
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
