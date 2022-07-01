import classes from './Navbar.module.css';
import { NavItem } from '../../../models/NavItem';
import Link from 'next/link';
interface Props{
    data:NavItem[];
}
const Navbar = ({data}:Props) => {
    return (
      <nav className={classes.Navbar}>
        {data.map((deta) => (
          <a key={deta.id}>
            <Link
              href={{
                pathname: `${deta.url}`,
                query: {},
              }}
            >
              {deta.name}
            </Link>
          </a>
        ))}
      </nav>
    );
}
export default Navbar;