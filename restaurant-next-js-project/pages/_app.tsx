import '../styles/globals.css'
import type { AppProps } from 'next/app'
import StandardLayout from '../layout/StandardLayout'

function MyApp({ Component, pageProps }: AppProps) {
  return (
    <StandardLayout>
      <Component {...pageProps} />
    </StandardLayout>
  );
}
export default MyApp
