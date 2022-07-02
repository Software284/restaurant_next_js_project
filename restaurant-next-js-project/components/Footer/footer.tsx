import classes from './footer.module.css';
import { footer } from '../../static-data';
import Link from 'next/link';
const Footer = () => {
    return (
      <div className={classes.Footer}>
        <div className={classes.BoxContainer}>
          {footer.map((data) => {
            return (
              <div className={classes.Box} key={data.title}>
                <h3>{data.title}</h3>
                {data.item.map((Footerdata, index) => {
                  return (
                    <Link href="/" key={index}>
                      <a>{Footerdata}</a>
                    </Link>
                  );
                })}
              </div>
            );
          })}
        </div>
        <div className={classes.Credit}>
          copyright @ 2021 by <span>mr. web designer</span>
        </div>
      </div>
    );
}
export default Footer;