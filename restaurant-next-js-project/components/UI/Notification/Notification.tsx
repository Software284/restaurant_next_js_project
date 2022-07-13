import classes from './Notification.module.css';
import ReactDOM from "react-dom";
interface Props{
    timeStamp:Date,
    message:string,
    status:string
}

function Notification(props:Props) {
  const { timeStamp, message, status } = props;

  let statusClasses = "";

  if (status === "success") {
    statusClasses = classes.success;
  }

  if (status === "error") {
    statusClasses = classes.error;
  }

  const cssClasses = `${classes.notification} ${statusClasses}`;

  return ReactDOM.createPortal(
    <div className={cssClasses}>
      <h2>{status}</h2>
      <p>{message}</p>
      <p>{timeStamp}</p>
    </div>,
    document.getElementById("notifications")!
  );
}

export default Notification;