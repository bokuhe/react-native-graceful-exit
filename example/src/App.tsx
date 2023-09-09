import * as React from 'react';

import { StyleSheet, View, Button } from 'react-native';
import { GracefulExit } from '@sleiv/react-native-graceful-exit';

export default function App() {
  const exitApp = async () => {
    GracefulExit.exit().catch((e) => {
      console.error(e);
    });
  };

  return (
    <View style={styles.container}>
      <Button title="Exit App" onPress={exitApp} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
