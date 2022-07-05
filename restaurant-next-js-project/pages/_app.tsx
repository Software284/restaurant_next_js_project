import '../styles/globals.css';
import type { AppProps } from 'next/app';
import StandardLayout from '../layout/StandardLayout';
import {Provider} from 'react-redux';
import {store} from '../store/store';
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
