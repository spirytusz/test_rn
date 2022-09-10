import React from 'react';
import {Button, StyleSheet, View, NativeModules} from 'react-native';
import {CustomView} from './CustomView';
import ActivityStarter from './ActivityStarter';

const App = () => {
  return (
    <View style={styles.container}>
      <CustomView />
      <Button
        onPress={() => {
          ActivityStarter.navigateToSecondActivity();
        }}
        title="Click to see expected behaviours!"
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
  },
});

export default App;
