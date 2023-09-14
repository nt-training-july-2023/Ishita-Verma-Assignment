import {React,useState} from 'react'
import OrganizationTab from './OrganizationTab/OrganizationTab';
import ProfileTab from './ProfileTab/ProfileTab';

const EmployeeDashboard = () => {

  const [activeTab, setActiveTab] = useState('profile');
  const switchToProfileTab = () => {
    setActiveTab('profile');
  };

  const switchToOrganizationTab = () => {
    setActiveTab('organization');
  };
  return (
    <div className='container'>
    <div className='admin_heading'>Employee Dashboard</div>
  <div className='admin_tabs'>
  <div className={`admin_employee ${activeTab === 'profile' ? 'active' : ''}`} onClick={switchToProfileTab}>
      Profile
    </div>
    <div className={`admin_manager ${activeTab === 'organization' ? 'active' : ''}`} onClick={switchToOrganizationTab}>
      Organization
    </div>
    </div>
    <div className='card_container'>
      {activeTab === 'profile' && (
          <div>
           <ProfileTab/>
          </div>
        )}
         {activeTab === 'organization' && (
          <div >
           <OrganizationTab/>
          </div>
        )}

      </div>
    </div>
  )
}

export default EmployeeDashboard
