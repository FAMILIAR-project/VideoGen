/**
 */
package playlist.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import playlist.PlaylistFactory;
import playlist.vids;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>vids</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class vidsTest extends TestCase {

	/**
	 * The fixture for this vids test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected vids fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(vidsTest.class);
	}

	/**
	 * Constructs a new vids test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public vidsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this vids test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(vids fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this vids test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected vids getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PlaylistFactory.eINSTANCE.createvids());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //vidsTest
