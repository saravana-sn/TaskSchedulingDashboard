using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Users_db
{
    #region Addpeople
    public class Addpeople
    {
        #region Member Variables
        protected int _aid;
        protected int _id;
        protected int _lid;
        protected int _Tasknumber;
        #endregion
        #region Constructors
        public Addpeople() { }
        public Addpeople(int id, int lid, int Tasknumber)
        {
            this._id=id;
            this._lid=lid;
            this._Tasknumber=Tasknumber;
        }
        #endregion
        #region Public Properties
        public virtual int Aid
        {
            get {return _aid;}
            set {_aid=value;}
        }
        public virtual int Id
        {
            get {return _id;}
            set {_id=value;}
        }
        public virtual int Lid
        {
            get {return _lid;}
            set {_lid=value;}
        }
        public virtual int Tasknumber
        {
            get {return _Tasknumber;}
            set {_Tasknumber=value;}
        }
        #endregion
    }
    #endregion
}using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Users_db
{
    #region Admin
    public class Admin
    {
        #region Member Variables
        protected int _id;
        protected string _full_name;
        protected string _username;
        protected string _password;
        protected string _phone;
        protected string _emailid;
        protected string _gender;
        #endregion
        #region Constructors
        public Admin() { }
        public Admin(string full_name, string username, string password, string phone, string emailid, string gender)
        {
            this._full_name=full_name;
            this._username=username;
            this._password=password;
            this._phone=phone;
            this._emailid=emailid;
            this._gender=gender;
        }
        #endregion
        #region Public Properties
        public virtual int Id
        {
            get {return _id;}
            set {_id=value;}
        }
        public virtual string Full_name
        {
            get {return _full_name;}
            set {_full_name=value;}
        }
        public virtual string Username
        {
            get {return _username;}
            set {_username=value;}
        }
        public virtual string Password
        {
            get {return _password;}
            set {_password=value;}
        }
        public virtual string Phone
        {
            get {return _phone;}
            set {_phone=value;}
        }
        public virtual string Emailid
        {
            get {return _emailid;}
            set {_emailid=value;}
        }
        public virtual string Gender
        {
            get {return _gender;}
            set {_gender=value;}
        }
        #endregion
    }
    #endregion
}using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Users_db
{
    #region Pastaddpeople
    public class Pastaddpeople
    {
        #region Member Variables
        protected int _aid;
        protected int _id;
        protected int _lid;
        protected int _Task_number;
        #endregion
        #region Constructors
        public Pastaddpeople() { }
        public Pastaddpeople(int id, int lid, int Task_number)
        {
            this._id=id;
            this._lid=lid;
            this._Task_number=Task_number;
        }
        #endregion
        #region Public Properties
        public virtual int Aid
        {
            get {return _aid;}
            set {_aid=value;}
        }
        public virtual int Id
        {
            get {return _id;}
            set {_id=value;}
        }
        public virtual int Lid
        {
            get {return _lid;}
            set {_lid=value;}
        }
        public virtual int Task_number
        {
            get {return _Task_number;}
            set {_Task_number=value;}
        }
        #endregion
    }
    #endregion
}using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Users_db
{
    #region Pasttask
    public class Pasttask
    {
        #region Member Variables
        protected int _ID;
        protected string _TaskName;
        protected unknown _StartDate;
        protected unknown _EndDate;
        protected int _Progress;
        protected int _Tasknumber;
        #endregion
        #region Constructors
        public Pasttask() { }
        public Pasttask(string TaskName, unknown StartDate, unknown EndDate, int Progress, int Tasknumber)
        {
            this._TaskName=TaskName;
            this._StartDate=StartDate;
            this._EndDate=EndDate;
            this._Progress=Progress;
            this._Tasknumber=Tasknumber;
        }
        #endregion
        #region Public Properties
        public virtual int ID
        {
            get {return _ID;}
            set {_ID=value;}
        }
        public virtual string TaskName
        {
            get {return _TaskName;}
            set {_TaskName=value;}
        }
        public virtual unknown StartDate
        {
            get {return _StartDate;}
            set {_StartDate=value;}
        }
        public virtual unknown EndDate
        {
            get {return _EndDate;}
            set {_EndDate=value;}
        }
        public virtual int Progress
        {
            get {return _Progress;}
            set {_Progress=value;}
        }
        public virtual int Tasknumber
        {
            get {return _Tasknumber;}
            set {_Tasknumber=value;}
        }
        #endregion
    }
    #endregion
}using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Users_db
{
    #region Properties
    public class Properties
    {
        #region Member Variables
        protected int _id;
        protected string _TaskName;
        protected unknown _StartDate;
        protected unknown _EndDate;
        protected int _Progress;
        protected int _Tasknumber;
        protected int _Priority;
        #endregion
        #region Constructors
        public Properties() { }
        public Properties(string TaskName, unknown StartDate, unknown EndDate, int Progress, int Tasknumber, int Priority)
        {
            this._TaskName=TaskName;
            this._StartDate=StartDate;
            this._EndDate=EndDate;
            this._Progress=Progress;
            this._Tasknumber=Tasknumber;
            this._Priority=Priority;
        }
        #endregion
        #region Public Properties
        public virtual int Id
        {
            get {return _id;}
            set {_id=value;}
        }
        public virtual string TaskName
        {
            get {return _TaskName;}
            set {_TaskName=value;}
        }
        public virtual unknown StartDate
        {
            get {return _StartDate;}
            set {_StartDate=value;}
        }
        public virtual unknown EndDate
        {
            get {return _EndDate;}
            set {_EndDate=value;}
        }
        public virtual int Progress
        {
            get {return _Progress;}
            set {_Progress=value;}
        }
        public virtual int Tasknumber
        {
            get {return _Tasknumber;}
            set {_Tasknumber=value;}
        }
        public virtual int Priority
        {
            get {return _Priority;}
            set {_Priority=value;}
        }
        #endregion
    }
    #endregion
}using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Users_db
{
    #region Users
    public class Users
    {
        #region Member Variables
        protected int _id;
        protected string _full_name;
        protected string _username;
        protected string _password;
        protected string _phone;
        protected string _emailid;
        protected string _gender;
        #endregion
        #region Constructors
        public Users() { }
        public Users(string full_name, string username, string password, string phone, string emailid, string gender)
        {
            this._full_name=full_name;
            this._username=username;
            this._password=password;
            this._phone=phone;
            this._emailid=emailid;
            this._gender=gender;
        }
        #endregion
        #region Public Properties
        public virtual int Id
        {
            get {return _id;}
            set {_id=value;}
        }
        public virtual string Full_name
        {
            get {return _full_name;}
            set {_full_name=value;}
        }
        public virtual string Username
        {
            get {return _username;}
            set {_username=value;}
        }
        public virtual string Password
        {
            get {return _password;}
            set {_password=value;}
        }
        public virtual string Phone
        {
            get {return _phone;}
            set {_phone=value;}
        }
        public virtual string Emailid
        {
            get {return _emailid;}
            set {_emailid=value;}
        }
        public virtual string Gender
        {
            get {return _gender;}
            set {_gender=value;}
        }
        #endregion
    }
    #endregion
}using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Users_db
{
    #region Users
    public class Users
    {
        #region Member Variables
        protected int _id;
        protected string _full_name;
        protected string _username;
        protected string _password;
        protected string _phone;
        protected string _emailid;
        protected string _gender;
        #endregion
        #region Constructors
        public Users() { }
        public Users(string full_name, string username, string password, string phone, string emailid, string gender)
        {
            this._full_name=full_name;
            this._username=username;
            this._password=password;
            this._phone=phone;
            this._emailid=emailid;
            this._gender=gender;
        }
        #endregion
        #region Public Properties
        public virtual int Id
        {
            get {return _id;}
            set {_id=value;}
        }
        public virtual string Full_name
        {
            get {return _full_name;}
            set {_full_name=value;}
        }
        public virtual string Username
        {
            get {return _username;}
            set {_username=value;}
        }
        public virtual string Password
        {
            get {return _password;}
            set {_password=value;}
        }
        public virtual string Phone
        {
            get {return _phone;}
            set {_phone=value;}
        }
        public virtual string Emailid
        {
            get {return _emailid;}
            set {_emailid=value;}
        }
        public virtual string Gender
        {
            get {return _gender;}
            set {_gender=value;}
        }
        #endregion
    }
    #endregion
}