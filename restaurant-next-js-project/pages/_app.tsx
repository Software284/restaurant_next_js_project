import '../styles/globals.css';
import type { AppProps } from 'next/app';
import StandardLayout from '../layout/StandardLayout';
import {Provider} from 'react-redux';
import {createStore} from 'redux';
import reducer from '../store/reducer';
const store:any = createStore(reducer);
function MyApp({ Component, pageProps }: AppProps) {
  return (
    <Provider store={store}>
      <StandardLayout>
        <Component {...pageProps} />
      </StandardLayout>
    </Provider>
  );
}
export default MyApp
