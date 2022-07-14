import classes from './Navbar.module.css';
import { NavItem } from '../../../models/NavItem';
import Link from 'next/link';
interface Props{
    data:NavItem[];
}
const Navbar: React.FC<Props> = (props) => {
    return (
      <nav className={classes.Navbar}>
        <ul>
          {props.data.map((deta) => (
            <li key={deta.id}>
              <Link
                href={{
                  pathname: `${deta.url}`,
                  query: {},
                }}
              >
                <a>{deta.name}</a>
              </Link>
            </li>
          ))}
        </ul>
      </nav>
    );
}
export default Navbar;