import { Fragment } from "react";
import Navigation from "../components/Navigation/navigation";
import Footer from "../components/Footer/footer";
const StandardLayout = (props:any) => {
    return (
        <Fragment>
            <Navigation/>
            <main>{props.children}</main>
            <Footer/>
        </Fragment>
    );
}
export default StandardLayout;